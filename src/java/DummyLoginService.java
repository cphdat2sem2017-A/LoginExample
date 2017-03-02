/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tobias
 */
public class DummyLoginService implements LoginService
{

    @Override
    public User login(String email, String password)
    {
        if("tog@cphbusiness.dk".equals(email) && "12345678".equals(password))
        {
            return new User("Tobias", email);
        }
        return null;
    }
    
}
