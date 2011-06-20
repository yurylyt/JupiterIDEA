package org.jupiter.idea.ui.tree;

import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.util.treeView.AbstractTreeNode;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.SimpleTextAttributes;
import com.intellij.util.ui.UIUtil;
import org.jetbrains.annotations.NotNull;
import org.jupiter.idea.ui.JupiterIcons;
import org.jupiter.model.JupiterConstants;
import org.jupiter.model.ReviewIssueItem;
import org.jupiter.model.review.ReviewIssue;

import javax.swing.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Author: Yuri Lytvynenko
 * Date: 07.06.11
 * Time: 7:50
 */
public class IssueNode extends AbstractTreeNode<ReviewIssueItem> implements NavigatableReviewItem {

    private static Map<String, Icon> icons;

    protected IssueNode(Project project, ReviewIssueItem value) {
        super(project, value);
    }

    @NotNull
    @Override
    public Collection<? extends AbstractTreeNode> getChildren() {
        return new LinkedList<AbstractTreeNode>();
    }

    @Override
    protected void update(PresentationData presentation) {
        ReviewIssue issue = getValue().getReviewIssue();
        SimpleTextAttributes attrs = SimpleTextAttributes.REGULAR_ATTRIBUTES;
        String status = issue.getStatus();
        if (status.equals(JupiterConstants.STATUS_RESOLVED)) {
            attrs = new SimpleTextAttributes(SimpleTextAttributes.STYLE_STRIKEOUT, null);
        } else if (status.equals(JupiterConstants.STATUS_CLOSED)) {
            attrs = new SimpleTextAttributes(SimpleTextAttributes.STYLE_STRIKEOUT | SimpleTextAttributes.STYLE_BOLD, UIUtil.getInactiveTextColor());
        } else if (status.equals(JupiterConstants.STATUS_REOPENED)) {
            attrs = new SimpleTextAttributes(SimpleTextAttributes.STYLE_WAVED, null);
        }
        String iconPath = getLastWord(issue.getSeverity());

        SimpleTextAttributes lineAttrs = SimpleTextAttributes.GRAY_ATTRIBUTES;
        presentation.addText(issue.getSummary(), attrs);
        String info = String.format(" [%s, %s]", getLastWord(status), getLastWord(issue.getSeverity()));
        presentation.addText(info, lineAttrs);
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
        icons.put("trivial", JupiterIcons.SEVERITY_TRIVIAL);
        icons.put("minor", JupiterIcons.SEVERITY_MINOR);
        icons.put("normal", JupiterIcons.SEVERITY_NORMAL);
        icons.put("major", JupiterIcons.SEVERITY_MAJOR);
        icons.put("critical", JupiterIcons.SEVERITY_CRITICAL);
    }

    private String getLastWord(String statusStr) {
        int index = statusStr.lastIndexOf(".");
        return index > 0 ? statusStr.substring(index + 1) : "";
    }

    public VirtualFile getVirtualFile() {
        return getValue().getVirtualFile();
    }

    public int getOffset() {
        return getValue().getRangeMarker().getStartOffset();
    }
}
