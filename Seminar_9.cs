using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Homeworks__2023
{
    internal class Seminar_9
    {
        static int Request(string message)
        {
            Console.Write(message);

            int result = int.Parse(Console.ReadLine());
            return result;
        }

        static void BackToFront(int n, int m)
        {
            int i = m + 1;
            while (i > n)
            {
                i--;
                
                Console.Write($"{i}, ");
            }
            Console.ReadLine();

        }
        static void SumBetweenEl(int m, int n)
        {
            int i = m + 1;
            int sum = 0;
            while (i > n) { i--; sum = sum + i; }
            Console.WriteLine($"Сумма натуральных чисел в промежутке от {n} до {m} равна: {sum}");
            Console.ReadLine();

        }
        static int A(int m, int n)
        {
            if (m == 0)
                return n + 1;
            else
             if ((m != 0) && (n == 0))
                return A(m - 1, 1);
            else
                return A(m - 1, A(m, n - 1));

        }
        static void Main(string[] args)

        {
            Console.WriteLine("Задача 64");
            int nN = Request("Задайте начальный элемент промежутка меду натуральными числами: ");
            int mM = Request("Задайте конечный элемент промежутка меду натуральными числами: ");
            BackToFront(nN, mM);

            Console.WriteLine("Задача 66");
            int N = Request("Задайте начальный элемент промежутка меду натуральными числами: ");
            int M = Request("Задайте конечный элемент промежутка меду натуральными числами: ");
            SumBetweenEl(M, N);

            Console.WriteLine("Задача 68");
            int m = Request("Введите положительное число от 0 до 3: ");
            int n = Request("Введите положительное число от 0 до 5: ");
            int res = A(m, n);
            Console.Write($"n = {n}, m = {m}, A(m,n) = {res}");
            Console.ReadLine();

        }
    }
}
