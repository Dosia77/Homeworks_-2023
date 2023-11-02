using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Homeworks__2023
{
    internal class Seminar8_5
    {
        static void PrintArray(int[,] array, int n)
        {
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {

                    Console.Write("{0,3}", array[i, j]);
                }
                Console.WriteLine();
            }
        }
        static int[,] GetArray(int n)
        {
            int[,] arrSpiral = new int[n, n];
            int i = 0, j = 0, value = 1;

            while (value <= n * n)
            {
                arrSpiral[i, j] = value;
                value++;
                if (i <= j + 1 && i + j < n - 1) j++;
                else if (i < j && i + j >= n - 1) i++;
                else if (i >= j && i + j > n - 1) j--;
                else i--;
            }
            return arrSpiral;
        }
        static void Main()
        {
            int n = 4;
            int[,] a = GetArray(n);
            PrintArray(a, n);
            Console.ReadLine();

        }
    }
}
