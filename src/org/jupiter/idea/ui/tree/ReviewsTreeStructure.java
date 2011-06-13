package org.jupiter.idea.ui.tree;

import com.intellij.ide.projectView.TreeStructureProvider;
import com.intellij.ide.util.treeView.AbstractTreeStructureBase;
import com.intellij.openapi.project.Project;
import org.jupiter.model.review.Review;
import org.jupiter.service.ReviewManager;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: Yuri Lytvynenko
 * Date: 06.06.11
 * Time: 23:21
 */
public class ReviewsTreeStructure extends AbstractTreeStructureBase {
    private Project project;
    private Review review;
    private ReviewManager reviewManager;
    private ReviewNode reviewNode;

    public ReviewsTreeStructure(Project project, Review review, ReviewManager reviewManager) {
        super(project);
        this.project = project;
        this.review = review;
        this.reviewManager = reviewManager;
    }

    @Override
    public Object getRootElement() {
        if (reviewNode == null) {
            reviewNode = new ReviewNode(project, this.review, reviewManager);
        }
        return reviewNode;
    }

    @Override
    public void commit() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean hasSomethingToCommit() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<TreeStructureProvider> getProviders() {
        return new LinkedList<TreeStructureProvider>();
    }
}
