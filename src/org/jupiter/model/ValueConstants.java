package org.jupiter.model;

/**
 * Author: Iurii Lytvynenko
 * Date: 29.05.11
 * Time: 17:36
 */
public class ValueConstants {
    public static final String STATUS_RESOLVED = "item.status.label.resolved";
    public static final String STATUS_CLOSED = "item.status.label.closed";

    public static final String[] SEVERITIES = {
            "item.label.unset",
            "item.severity.label.critical",
            "item.severity.label.major",
            "item.severity.label.normal",
            "item.severity.label.minor",
            "item.severity.label.trivial"
    };

    public static final String[] TYPES = {
            "item.label.unset",
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
            "item.label.unset",
            "item.resolution.label.validNeedsfixing",
            "item.resolution.label.validFixlater",
            "item.resolution.label.validDuplicate",
            "item.resolution.label.validWontfix",
            "item.resolution.label.invalidWontfix",
            "item.resolution.label.unsureValidity"
    };

    public static final String[] STATUSES = {
            "item.label.unset",
            "item.status.label.open",
            "item.status.label.resolved",
            "item.status.label.closed",
            "item.status.label.reopened"
    };
}

