using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace sdi3_5.Cli_SOAP_C_SHARP
{
    class Program
    { 

        static void Main(string[] args)
        {
            Command[] commands = new Command[4];

            commands[0] = new EndProgram();
            commands[1] = new ListUsers();
            commands[2] = new ListUsers();
            commands[3] = new ListUsers();
            Console.WriteLine("Welcome to the SOAP client developed by Pablo García Miranda & Fernando Freije Fuente!" +
               " \n\t\t1 - List users\n\t\t2 - Enable / Disable user\n\t\t3 - Delete user\n\t\t0 - Salir");


            int? option = ReadInt("Option");
            while (option == null || option < 0 || option > commands.Count())
            {
                   Console.WriteLine("That input is not valid. Please, try again");
                   option = ReadInt("Option");
            }

            commands[option??0].Execute();

        }


        private static int? ReadInt(string text)
        {
            Console.Write(text+":" );
            var value = Console.ReadLine();
            int? number = null;
            try
            {
                number = int.Parse(value);
            }
            catch (FormatException e)
            {
                number = null;
            }
            return number;
        }


       
    }
}
