package org.jupiter;

import com.intellij.CommonBundle;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.PropertyKey;

import java.util.ResourceBundle;

/**
 * Author: Iurii Lytvynenko
 * Date: 05.06.11
 * Time: 16:47
 */
public class JupiterBundle {
    private static ResourceBundle bundleInstance;

    @NonNls private static final String BUNDLE = "jupiter";

    private JupiterBundle() {
    }

    public static String message(@PropertyKey(resourceBundle = BUNDLE) String key, Object... params) {
        return CommonBundle.message(getBundle(), key, params);
    }

    private static ResourceBundle getBundle() {
        if (bundleInstance == null) {
            bundleInstance = ResourceBundle.getBundle(BUNDLE);
        }
        return bundleInstance;
    }
}
