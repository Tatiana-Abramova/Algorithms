package algo;

/**
 * A support container class for comparative testing.
 */
public class Actions {

    /** Test name */
    private String testName;

    /** Actions to test */
    private ActionDetail[] actions;

    public Actions(String testName, ActionDetail... details) {
        this.testName = testName;
        this.actions = details;
    }

    public String getTestName() {
        return testName;
    }

    public ActionDetail[] getActions() {
        return actions;
    }

    /**
     * Method under test and its description.
     */
    public static class ActionDetail {

        /** Description */
        private String actionName;

        /** Method under test */
        private Action action;

        public ActionDetail(String actionName, Action action) {
            this.actionName = actionName;
            this.action = action;
        }

        public String getActionName() {
            return actionName;
        }

        public Action getAction() {
            return action;
        }
    }

    /**
     * Functional interface that should be implemented with methods under test.
     */
    public interface Action {
        void action();
    }
}
