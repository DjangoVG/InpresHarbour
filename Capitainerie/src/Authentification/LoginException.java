package Authentification;

class LoginException extends Exception 
{
    public LoginException()
    {
        DialogErreur dia = new DialogErreur(null, true);
        dia.setVisible(true);
    } 
}
