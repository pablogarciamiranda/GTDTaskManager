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
            AdminService.AdminService service = new AdminService.AdminServiceClient();

            Console.WriteLine(service.findAllUsers());

        }
    }
}
