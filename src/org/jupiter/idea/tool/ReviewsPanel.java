package org.jupiter.idea.tool;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.SimpleToolWindowPanel;

import java.awt.*;

/**
 * Author: Iurii Lytvynenko
 * Date: 05.06.11
 * Time: 16:24
 */
public class ReviewsPanel extends SimpleToolWindowPanel {
    private Project myProject;

    public ReviewsPanel(Project project) {
        super(false, true);
        this.myProject = project;
        this.setLayout(new FlowLayout());
        Label label = new Label("Wazuup!!!!");
        this.add(label);
    }
}
