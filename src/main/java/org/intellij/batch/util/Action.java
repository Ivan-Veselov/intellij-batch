package org.intellij.batch.util;

import org.jetbrains.annotations.NotNull;

/**
 * A functional interface which represents an action with no parameters and no returning value.
 */
public interface Action {
    /**
     * An action which does nothing.
     */
    @NotNull Action noAction = new Action() {
        @Override
        public void execute() {
        }
    };

    /**
     * A method which executes an action represented by this functional interface.
     */
    void execute();
}
