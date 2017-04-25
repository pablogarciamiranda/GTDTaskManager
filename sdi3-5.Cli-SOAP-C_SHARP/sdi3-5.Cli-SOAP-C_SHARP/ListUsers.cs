using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace sdi3_5.Cli_SOAP_C_SHARP
{
    class ListUsers : Command
    {
        public void Execute()
        {
            Console.WriteLine("Users:");
            PrintHeader();
            AdminService.AdminService service = new AdminService.AdminServiceClient();
            AdminService.userInfo[] list = service.findAllUsersInfo(new AdminService.findAllUsersInfo()).@return;
            foreach (AdminService.userInfo u in list)
                PrintLine(u);
        }

        private static void PrintHeader()
        {
            Console.WriteLine("{0} {1} {2} {3} {4} {5} {6}", "\tID\t",
                     "LOGIN\t", "EMAIL\t\t",
                     "Tasks Finished_\t\t",
                     "Tasks Finished Late\t\t", "Tasks Planned\t\t",
                     "Tasks Unplanned\t\t");
            Console.WriteLine(new String('-', 120));
        }

        private static void PrintLine(AdminService.userInfo u)
        {
            Console.WriteLine("\t{0}\t{1}\t{2}\t\t{3}\t\t{4}\t\t{5}\t\t{6}\n",
                    u.id, u.login, u.email, u.completedTasks,
                    u.lateCompletedTasks, u.plannedTasks,
                    u.unplannedTasks);
        }
    }
}
