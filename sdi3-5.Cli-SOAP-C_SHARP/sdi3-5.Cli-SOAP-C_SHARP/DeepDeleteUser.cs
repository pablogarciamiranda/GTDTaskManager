﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace sdi3_5.Cli_SOAP_C_SHARP
{
    class DeepDeleteUser : Command
    {
        public void Execute()
        {
                AdminService.AdminService service = new AdminService.AdminServiceClient();

                long id = Util.ReadLong("Enter an id",0);

                AdminService.findUserById requestUser = new AdminService.findUserById();
                requestUser.arg0 = id;
                AdminService.user user = service.findUserById(requestUser).@return;

                if (user == null)
                {
                    Console.WriteLine("There is no user with " + "id " + id);
                    return;
                }

                AdminService.deepDeleteUser requestDelete = new AdminService.deepDeleteUser();
                requestDelete.arg0 = id;
                service.deepDeleteUser(requestDelete);
                Console.WriteLine("The user with id: " + id + " has been successfully deleted");
           
        }
    }
}
