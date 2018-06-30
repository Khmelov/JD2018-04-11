package by.it.kurmaz.project.java.controller;

class ActionResult {
    public Actions nextAction;
    public String jsp;

    public ActionResult(Actions nextAction) {
        this(nextAction,  nextAction.toString().toLowerCase());
    }

    public ActionResult (String jsp) {
        this(null, jsp);
    }

    public ActionResult(Actions nextAction, String jsp) {
        this.nextAction = nextAction;
        this.jsp = "/" + jsp + ".jsp";
    }
}
