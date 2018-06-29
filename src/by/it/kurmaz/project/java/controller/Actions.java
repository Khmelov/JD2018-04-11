package by.it.kurmaz.project.java.controller;

public enum Actions {
    INDEX {
        {
            cmd = new CmdIndex();
        }
    },
    MYINDEX {
        {
            cmd = new CmdMyIndex();
        }
    },
    LOGIN{
        {
            cmd = new CmdLogin();
        }
    },
    ADMLOGIN{
        {
            cmd = new CmdAdminLogin();
        }
    },SIGNUP{
        {
            cmd = new CmdSignUp();
        }
    },ADDRESS{
        {
            cmd = new CmdAddress();
        }
    }, ERROR{
        {
            cmd = new CmdError();
        }
    },
    PROFILE{
        {
            cmd = new CmdProfile();
        }
    },
    RESET{
        {
            cmd = new CmdReset();
        }
    },
    VIEWCATALOG {
        {
            cmd = new CmdViewCatalog();
        }
    },
    MAKEORDER {
        {
            cmd = new CmdOrder();
        }
    },
    LISTORDERS {
        {
            cmd = new CmdListOrders();
        }
    },
    ADDCATALOGITEM {
        {
            cmd = new CmdAddItem();
        }
    },
    GETSHIPPINGLIST {
        {
            cmd = new CmdShippingList();
        }
    };

    Cmd cmd = new CmdError();
    String jsp="/" + this.toString().toLowerCase() + ".jsp";
}
