package by.it.tayanovskii.calc;

public abstract class ReportBuilder {
 protected Report report=new Report();
 public abstract void addEvent(String event);
 public abstract void addHead();
 public abstract void addStartTime();
 public abstract void addEndTime();
 public abstract void addEvent(Exception ex);

}
