package org.jupiter.model;

/**
 * Author: Iurii Lytvynenko
 * Date: 29.05.11
 * Time: 17:36
 */
public class ValueConstants {
    public static final String[] SEVERITIES = {
            null,
            "item.severity.label.critical",
            "item.severity.label.major",
            "item.severity.label.normal",
            "item.severity.label.minor",
            "item.severity.label.trivial"
    };

    public static final String[] TYPES = {
            null,
            "item.type.label.codingStandards",
            "item.type.label.programLogic",
            "item.type.label.optimization",
            "item.type.label.usability",
            "item.type.label.clarity",
            "item.type.label.missing",
            "item.type.label.irrelevant",
            "item.type.label.suggestion",
            "item.type.label.other"
    };

    public static final String[] RESOLUTIONS = {
            null,
            "item.resolution.label.validNeedsfixing",
            "item.resolution.label.validFixlater",
            "item.resolution.label.validDuplicate",
            "item.resolution.label.validWontfix",
            "item.resolution.label.invalidWontfix",
            "item.resolution.label.unsureValidity"
    };

    public static final String[] STATUSES = {
            null,
            "item.status.label.open",
            "item.status.label.resolved",
            "item.status.label.closed",
            "item.status.label.reopened"
    };
}

