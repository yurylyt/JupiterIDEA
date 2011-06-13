package org.jupiter.idea.ui.tree;

import com.intellij.openapi.vfs.VirtualFile;

/**
 * Author: Yuri Lytvynenko
 * Date: 12.06.11
 * Time: 11:25
 */
public interface NavigatableReviewItem {
    VirtualFile getVirtualFile();
    int getOffset();
}
