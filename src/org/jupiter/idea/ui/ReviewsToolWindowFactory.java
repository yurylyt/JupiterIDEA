package org.jupiter.idea.ui;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;

/**
 * Author: Yuri Lytvynenko
 * Date: 05.06.11
 * Time: 16:56
 */
public class ReviewsToolWindowFactory implements ToolWindowFactory {
    public void createToolWindowContent(Project project, ToolWindow toolWindow) {
        ReviewsView view = ServiceManager.getService(project, ReviewsView.class);
        view.initToolWindow(toolWindow);
    }
}
