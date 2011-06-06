package org.jupiter.idea.tool;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.intellij.ui.content.ContentManager;
import org.jupiter.JupiterBundle;

/**
 * Author: Iurii Lytvynenko
 * Date: 05.06.11
 * Time: 16:39
 */
public class ReviewsView implements Disposable {
    private Project myProject;

    public ReviewsView(Project project) {
        this.myProject = project;
    }

    public void initToolWindow(ToolWindow window) {
        ContentManager contentManager = window.getContentManager();
        Content reviewsContent= ContentFactory.SERVICE.getInstance()
                .createContent(null, JupiterBundle.message("tool.window.title"), false);
        ReviewsPanel panel = new ReviewsPanel(myProject);
        reviewsContent.setComponent(panel);
        reviewsContent.setCloseable(false);
        contentManager.addContent(reviewsContent);
    }

    public void dispose() {
        // do nothing for now.
    }
}
