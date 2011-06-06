package org.jupiter.idea.tool;

import com.intellij.psi.PsiTreeChangeAdapter;
import com.intellij.psi.PsiTreeChangeEvent;

/**
 * Author: Iurii Lytvynenko
 * Date: 05.06.11
 * Time: 16:05
 */
public class MyPsiTreeChangeListener extends PsiTreeChangeAdapter {
    @Override
    public void childAdded(PsiTreeChangeEvent event) {
        super.childAdded(event);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
