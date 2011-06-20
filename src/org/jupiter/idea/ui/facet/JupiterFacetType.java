package org.jupiter.idea.ui.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetType;
import com.intellij.facet.FacetTypeId;
import com.intellij.facet.autodetecting.FacetDetector;
import com.intellij.facet.autodetecting.FacetDetectorRegistry;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileFilter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jupiter.idea.ui.JupiterIcons;
import org.jupiter.idea.ui.file.JupiterFileTypeFactory;
import org.jupiter.model.JupiterConstants;

import javax.swing.*;
import java.util.Collection;

/**
 * Author: Yuri Lytvynenko
 * Date: 20.06.11
 * Time: 22:01
 */
public class JupiterFacetType extends FacetType<JupiterFacet, JupiterFacetConfiguration> {
    public JupiterFacetType() {
        super(new FacetTypeId<JupiterFacet>("jupiter"), "jupiter", "Jupiter");
    }

    @Override
    public JupiterFacetConfiguration createDefaultConfiguration() {
        return new JupiterFacetConfiguration();
    }

    @Override
    public JupiterFacet createFacet(@NotNull Module module, String name, @NotNull JupiterFacetConfiguration configuration, @Nullable Facet underlyingFacet) {
        return new JupiterFacet(this, module, name, configuration);
    }

    @Override
    public boolean isSuitableModuleType(ModuleType moduleType) {
        return true; // support all module types
    }

    @Override
    public void registerDetectors(FacetDetectorRegistry<JupiterFacetConfiguration> detectorRegistry) {
        FacetDetector<VirtualFile, JupiterFacetConfiguration> detector = new FacetDetector<VirtualFile, JupiterFacetConfiguration>("jupiter") {

            @Override
            public JupiterFacetConfiguration detectFacet(VirtualFile source, Collection<JupiterFacetConfiguration> existentFacetConfigurations) {
                if (!existentFacetConfigurations.isEmpty()) {
                    return existentFacetConfigurations.iterator().next();
                }
                return createDefaultConfiguration();
            }
        };
        VirtualFileFilter androidManifestFilter = new VirtualFileFilter() {
            public boolean accept(VirtualFile file) {
                return file.getName().equals(JupiterConstants.JUPITER_CONFIG_FILE_NAME);
            }
        };
        detectorRegistry.registerUniversalDetector(JupiterFileTypeFactory.FILE_TYPE, androidManifestFilter, detector);
    }

    @Override
    public Icon getIcon() {
        return JupiterIcons.JUPITER_ICON;
    }
}
