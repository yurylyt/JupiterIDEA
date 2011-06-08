package org.jupiter.idea.ui.tree;

import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.util.treeView.AbstractTreeNode;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.IconLoader;
import com.intellij.ui.SimpleTextAttributes;
import com.intellij.util.ui.UIUtil;
import org.jetbrains.annotations.NotNull;
import org.jupiter.model.ValueConstants;
import org.jupiter.model.review.ReviewIssue;

import javax.swing.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Author: Iurii Lytvynenko
 * Date: 07.06.11
 * Time: 7:50
 */
public class IssueNode extends AbstractTreeNode<ReviewIssue> {

    private static Map<String,Icon> icons;

    protected IssueNode(Project project, ReviewIssue value) {
        super(project, value);
    }

    @NotNull
    @Override
    public Collection<? extends AbstractTreeNode> getChildren() {
        return new LinkedList<AbstractTreeNode>();
    }

    @Override
    protected void update(PresentationData presentation) {
        ReviewIssue issue = getValue();
        SimpleTextAttributes attrs = SimpleTextAttributes.REGULAR_ATTRIBUTES;
        if (issue.getStatus().equals(ValueConstants.STATUS_RESOLVED)) {
            attrs = new SimpleTextAttributes(SimpleTextAttributes.STYLE_STRIKEOUT, null);
        } else if (issue.getStatus().equals(ValueConstants.STATUS_CLOSED)) {
            attrs = new SimpleTextAttributes(SimpleTextAttributes.STYLE_STRIKEOUT, UIUtil.getInactiveTextColor());
        }
        String iconPath = getStatusWord(issue.getStatus());
        presentation.addText(issue.getSummary(), attrs);
        presentation.setIcons(getIcon(iconPath));
    }

    private Icon getIcon(String iconPath) {
        if (icons == null) {
            initIconsMap();
        }
        return icons.get(iconPath);
    }

    private static synchronized void initIconsMap() {
        icons = new WeakHashMap<String, Icon>();
        icons.put("open", IconLoader.findIcon("/icons/status/open.png"));
        icons.put("resolved", IconLoader.findIcon("/icons/status/resolved.png"));
        icons.put("reopened", IconLoader.findIcon("/icons/status/reopened.png"));
        icons.put("closed", IconLoader.findIcon("/icons/status/closed.png"));
    }

    private String getStatusWord(String statusStr) {
        int index = statusStr.lastIndexOf(".");
        return index > 0 ? statusStr.substring(index + 1) : "";
    }
}
