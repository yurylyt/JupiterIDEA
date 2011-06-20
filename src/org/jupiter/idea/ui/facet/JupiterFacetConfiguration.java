package org.jupiter.idea.ui.facet;

import com.intellij.facet.FacetConfiguration;
import com.intellij.facet.ui.FacetEditorContext;
import com.intellij.facet.ui.FacetEditorTab;
import com.intellij.facet.ui.FacetValidatorsManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.WriteExternalException;
import org.jdom.Element;

/**
 * Author: Yuri Lytvynenko
 * Date: 20.06.11
 * Time: 22:02
 */
public class JupiterFacetConfiguration implements FacetConfiguration, PersistentStateComponent<JupiterFacetConfiguration> {
    @Override
    public FacetEditorTab[] createEditorTabs(FacetEditorContext editorContext, FacetValidatorsManager validatorsManager) {
        return new FacetEditorTab[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void readExternal(Element element) throws InvalidDataException {
    }

    @Override
    public void writeExternal(Element element) throws WriteExternalException {
    }

    @Override
    public JupiterFacetConfiguration getState() {
        return this;
    }

    @Override
    public void loadState(JupiterFacetConfiguration state) {
        // todo: copy values to this.
    }
}
