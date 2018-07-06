package by.it.krivenkova.project.java.controller;

/*public*/ enum Actions {
  INDEX {
      {
          cmd = new CmdIndex();
      }
  },
    CREATEROUTE {
        {
           cmd = new CmdCreateRoute();
        }
    },
    EDITUSERS{
        {
            cmd=new CmdEditUsers();
        }
    },
    LOGIN {
        {
            cmd = new CmdLogin();
        }
    },
    PROFILE {
        {
            cmd = new CmdProfile();
        }
    },
    SIGNUP {
        {
            cmd = new CmdSignUp();
        }
    },
    RESETDB {
        {
            cmd = new CmdResetDB();
        }
    },
    ERROR {
        {
            cmd = new CmdError();
        }
    };
    Cmd cmd = new CmdError();
    String jsp = "/"+this.toString().toLowerCase()+".jsp";

}
