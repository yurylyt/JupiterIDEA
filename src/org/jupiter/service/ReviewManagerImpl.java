package org.jupiter.service;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.EventDispatcher;
import org.jupiter.idea.ui.IssueUpdatedListener;
import org.jupiter.model.review.Review;
import org.jupiter.model.review.ReviewIssue;

import javax.swing.*;
import javax.xml.bind.JAXB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.util.WeakHashMap;

/**
 * Author: Yuri Lytvynenko
 * Date: 29.05.11
 * Time: 12:52
 */
public class ReviewManagerImpl implements ReviewManager {
    private Project project;

    private Timer updateTimer;
    private EventDispatcher<IssueUpdatedListener> dispatcher = EventDispatcher.create(IssueUpdatedListener.class);
    private static WeakHashMap<String, Review> reviewRegistry = new WeakHashMap<String, Review>();

    public ReviewManagerImpl(Project project) {
        this.project = project;
    }

    public Review getReview(String id) {
        if (!reviewRegistry.containsKey(id)) {
            VirtualFile reviewFile = getReviewFile();
            if (reviewFile != null) {
                try {
                    reviewRegistry.put(id, JAXB.unmarshal(reviewFile.getInputStream(), Review.class));
                } catch (IOException e) {
                    // TODO: Log
                    e.printStackTrace();
                }
            }
        }
        return reviewRegistry.get(id);
    }

    private VirtualFile getReviewFile() {
        VirtualFile baseDir = this.project.getBaseDir();
        VirtualFile reviewFile = null;
        if (baseDir != null) {
            VirtualFile reviewDir = baseDir.findFileByRelativePath("review");
            if (reviewDir != null) {
                for (VirtualFile child : reviewDir.getChildren()) {
                    if (child.getName().endsWith(".review")) {
                        reviewFile = child;
                        break;
                    }
                }
            }
        }
        return reviewFile;
    }

    public void saveReview(Review review) {
        VirtualFile reviewFile = getReviewFile();
        if (reviewFile == null) {
            throw new IllegalStateException("Review file not found");
        }
        try {
            OutputStream out = reviewFile.getOutputStream(this);
            try {
                JAXB.marshal(review, out);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't write review file", e);
        }
    }

    public void fireIssueUpdate(ReviewIssue issue) {
        scheduleUpdate(issue);
    }

    public void addIssueUpdatedListener(IssueUpdatedListener lst) {
        this.dispatcher.addListener(lst);
    }

    public void removeIssueUpdatedListener(IssueUpdatedListener lst) {
        this.dispatcher.removeListener(lst);
    }

    private void scheduleUpdate(final ReviewIssue updated) {
        if (updateTimer != null && updateTimer.isRunning()) {
            updateTimer.stop();
        }
        updateTimer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateReview(updated);
            }
        });
        updateTimer.setRepeats(false);
        updateTimer.start();
    }

    private void updateReview(final ReviewIssue updated) {
        ApplicationManager.getApplication().invokeLater(new Runnable() {
            public void run() {
                saveReview(getReview(""));
                dispatcher.getMulticaster().issueUpdated(updated);
            }
        });
    }

}
