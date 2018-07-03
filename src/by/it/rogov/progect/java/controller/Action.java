package by.it.rogov.progect.java.controller;

 enum Action {
    INDEX {
        {
            cmd = new CmdIndex();
        }
    },
    LOGIN {
        {
            cmd = new CmdLogin();
        }
    },
     RESETDB {
        {
            cmd = new CmdResetDB();

        }
    },
     LABRARY {
         {
             cmd = new CmdLabrary();

         }
     },
    SIGNUP {
        {
            cmd = new CmdSignUp();
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
