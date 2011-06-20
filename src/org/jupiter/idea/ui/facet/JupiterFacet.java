package org.jupiter.idea.ui.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetType;
import com.intellij.openapi.module.Module;
import org.jetbrains.annotations.NotNull;

/**
 * Author: Yuri Lytvynenko
 * Date: 20.06.11
 * Time: 22:01
 */
public class JupiterFacet extends Facet<JupiterFacetConfiguration> {
    public JupiterFacet(@NotNull FacetType facetType, @NotNull Module module, @NotNull String name, @NotNull JupiterFacetConfiguration configuration) {
        super(facetType, module, name, configuration, null);
    }


}
