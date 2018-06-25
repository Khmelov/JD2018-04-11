package by.it.kurmaz.project.java.controller;

public enum Actions {
    INDEX {
        {
            cmd = new CmdIndex();
            jsp = "/index.jsp";
        }
    }, LOGIN{
        {
            cmd = new CmdLogin();
            jsp = "/login.jsp";
        }
    }, SIGNUP{
        {
            cmd = new CmdSignUp();
            jsp = "/signup.jsp";
        }
    }, ERROR{
        {
            cmd = new CmdError();
            jsp = "/error.jsp";
        }
    },
    LOGOUT{
        {
            cmd = new CmdLogout();
            jsp = "/logout.jsp";
        }
    },
    VIEWCATALOG {
        {
            cmd = new CmdViewCatalog();
            jsp = "/catalog.jsp";
        }
    },
    VIEWORDER {
        {
            cmd = new CmdOrder();
            jsp = "/order.jsp";
        }
    },
    LISTORDERS {
        {
            cmd = new CmdListOrders();
            jsp = "/listorder.jsp";
        }
    },
    ADDCATALOGITEM {
        {
            cmd = new CmdAddItem();
            jsp = "/additem.jsp";
        }
    },
    GETSHIPPINGLIST {
        {
            cmd = new CmdShippingList();
            jsp = "/shippinglist.jsp";
        }
    };

    Cmd cmd = new CmdError();
    String jsp="/error.jsp";
}
