package org.jupiter.idea.ui;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.intellij.ui.content.ContentManager;
import org.jupiter.service.ReviewManager;

/**
 * Author: Yuri Lytvynenko
 * Date: 05.06.11
 * Time: 16:39
 */
public class ReviewsView implements Disposable {
    private Project myProject;
    private ReviewManager reviewManager;

    public ReviewsView(Project project, ReviewManager reviewManager) {
        this.myProject = project;
        this.reviewManager = reviewManager;
    }

    public void initToolWindow(ToolWindow window) {
        ContentManager contentManager = window.getContentManager();
        ReviewsUI reviewsUI = new ReviewsUI(myProject, reviewManager);

        Content content= ContentFactory.SERVICE.getInstance()
                .createContent(reviewsUI.create(), "", false);
        content.setCloseable(false);
        contentManager.addContent(content);
    }

    public void dispose() {
        // do nothing for now.
    }
}
