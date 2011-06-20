package org.jupiter.idea.ui.file;

import com.intellij.ide.highlighter.XmlLikeFileType;
import com.intellij.lang.xml.XMLLanguage;
import org.jetbrains.annotations.NotNull;
import org.jupiter.idea.ui.JupiterIcons;

import javax.swing.*;

/**
 * Author: Yuri Lytvynenko
 * Date: 20.06.11
 * Time: 23:06
 */
public class JupiterFileType extends XmlLikeFileType {
    public JupiterFileType() {
        super(XMLLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Jupiter file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Jupiter code review tool file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "review";
    }

    @Override
    public Icon getIcon() {
        return JupiterIcons.JUPITER_ICON;
    }
}
