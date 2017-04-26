using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace sdi3_5.Cli_SOAP_C_SHARP
{
    class Menu
    {
        public void Run()
        {
            int option = -1;
            while (option != 0)
            {
                Command[] commands = new Command[4];

                commands[0] = new EndProgram();
                commands[1] = new ListUsers();
                commands[2] = new DisableUser();
                commands[3] = new DeepDeleteUser();
                Console.WriteLine("Welcome to the SOAP client developed by Pablo García Miranda & Fernando Freije Fuente!" +
                   " \n\t\t1 - List users\n\t\t2 - Enable / Disable user\n\t\t3 - Delete user\n\t\t0 - Salir");


               option = Util.ReadInt("Enter an option", 0, commands.Count());

                try
                {
                    commands[option].Execute();
                }
                catch (Exception e)
                {
                    Console.WriteLine("There was a problem with the system");
                }
        }

        }
    }
}
