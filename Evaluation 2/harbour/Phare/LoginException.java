package Authentification;

class LoginException extends Exception 
{
    public LoginException()
    {
        System.out.println("ICI");
        DialogErreur dia = new DialogErreur(null, true);
        dia.setVisible(true);
    }
    
    
}
