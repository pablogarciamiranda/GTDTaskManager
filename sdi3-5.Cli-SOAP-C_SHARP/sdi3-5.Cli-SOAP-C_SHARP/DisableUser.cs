using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace sdi3_5.Cli_SOAP_C_SHARP
{
    class DisableUser : Command
    {
        public void Execute()
        {
            try
            {
                AdminService.AdminService service = new AdminService.AdminServiceClient();

                long id = Util.ReadLong("Enter an id",0);

                AdminService.findUserById requestUser = new AdminService.findUserById();
                requestUser.arg0 = id;
                AdminService.user user = service.findUserById(requestUser).@return;

               // if (user == null)
                    //Como hago esto?
                    // throw new AdminService.BusinessException("There is no user with " + "id "+ id);
                
                if (user.status.Equals(AdminService.userStatus.ENABLED))
                {
                    AdminService.disableUser requestDisable = new AdminService.disableUser();
                    requestDisable.arg0 = id;
                    service.disableUser(requestDisable);
                   Console.WriteLine("The user with id " + id + " has been "
                            + "successfully disabled");
                }
                else
                {
                        AdminService.enableUser requestEnable = new AdminService.enableUser();
                        requestEnable.arg0 = id;
                        service.enableUser(requestEnable);
                        Console.WriteLine("The user with id " + id + " has been "
                            + "successfully enabled");
                }
            }
            //No se como se hacen las exceptions
            //catch (AdminService.BusinessException b)
            //{
            //    Console.WriteLine("The user could not be disabled due to: \n\t"
            //            + b.message);
            //}
            catch (Exception e)
            {
                Console.WriteLine("There was a problem with the system");
            }
        }
    }
}
