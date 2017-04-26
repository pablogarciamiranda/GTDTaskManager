using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace sdi3_5.Cli_SOAP_C_SHARP
{
    class Util
    {
        public static int ReadInt(string text, int min, int max)
        {
            int? n = Util.ReadIntOrNull(text);
            while (n == null || n < min || n > max)
            {
                Console.WriteLine("That input is not valid. Please, try again");
                n = Util.ReadIntOrNull(text);
            }
            return n ?? -1;
        }

        public static int ReadInt(string text, int min)
        {
            int? n = Util.ReadIntOrNull(text);
            while (n == null || n < min)
            {
                Console.WriteLine("That input is not valid. Please, try again");
                n = Util.ReadIntOrNull(text);
            }
            return n ?? -1;
        }

        public static int ReadInt(string text)
        {
            int? n = Util.ReadIntOrNull(text);
            while (n == null)
            {
                Console.WriteLine("That input is not valid. Please, try again");
                n = Util.ReadIntOrNull(text);
            }
            return n ?? -1;
        }

        private static int? ReadIntOrNull(string text)
        {
            Console.Write(text + ":");
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

        public static long ReadLong(string text,int min)
        {
            long? n = Util.ReadLongOrNull(text);
            while (n == null || n < min)
            {
                Console.WriteLine("That input is not valid. Please, try again");
                n = null;
                n = Util.ReadLongOrNull(text);
            }
            return n??-1;
        }

        public static long ReadLong(string text, int min, int max)
        {
            long? n = Util.ReadLongOrNull(text);
            while (n == null || n < min || n > max)
            {
                Console.WriteLine("That input is not valid. Please, try again");
                n = null;
                n = Util.ReadLongOrNull(text);
            }
            return n ?? -1;
        }

        public static long ReadLong(string text)
        {
            long? n = Util.ReadLongOrNull(text);
            while (n == null)
            {
                Console.WriteLine("That input is not valid. Please, try again");
                n = null;
                n = Util.ReadLongOrNull(text);
            }
            return n ?? -1;
        }

        private static long? ReadLongOrNull(string text)
        {
            Console.Write(text + ":");
            var value = Console.ReadLine();
            long? number = null;
            try
            {
                number = long.Parse(value);
            }
            catch (FormatException e)
            {
                number = null;
            }
            return number;
        }
    }
}
