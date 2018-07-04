package by.it.krivenkova.project.java.controller;

/*public*/ enum Actions {
  /*  INDEX {
        {
            this.cmd = new CmdIndex();
          //  jsp = "/index.jsp";
        }
    },
    CREATEROUTE {
        {
          //  cmd = new CmdCreateRoute();
         //   jsp = "/login.jsp";
        }
    },
    EDITUSERS{
        {
            this.cmd=new CmdEditUsers();
          //  jsp = "/signup.jsp";
        }
    },
    EDITROUTE{
        {
            this.cmd=new CmdEditRoute();
            //  jsp = "/signup.jsp";
        }
    },
    LOGIN {
        {
            this.cmd = new CmdLogin();
        }
    },
    PROFILE {
        {
            this.cmd = new CmdProfile();
        }
    },
    SIGNUP {
        {
            this.cmd = new CmdSignUp();
        }
    },
    RESETDB {
        {
            this.cmd = new CmdResetDB();
        }
    },
    ERROR {
        {
            this.cmd = new CmdError();
          //  jsp = "/error.jsp";
        }
    };
    Cmd cmd;// = new CmdError();
//    String jsp = "/error.jsp";
    //String jsp = "/"+this.toString().toLowerCase()+".jsp";
*/
  INDEX {
      {
          cmd = new CmdIndex();
      }
  },
    CREATEROUTE {
        {
//            cmd = new CmdCreateRoute();
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
