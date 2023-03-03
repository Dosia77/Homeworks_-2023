using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Homeworks__2023
{
    internal class Seminar3_3
    {
        static void Palindrom(ref int n)

        {
            Console.WriteLine("Задача # 19");
            try
            {
                Console.Write("Введите пятизначное число: ");
                n = int.Parse(Console.ReadLine());
            }
            catch (Exception exc)
            {
                Console.WriteLine($"Ошибка ввода, начинай сначала!{exc.Message}");
                return;

            }

            if (n % 10 == n / 10000 && (n / 1000) % 10 == (n / 10) % 10)
                Console.WriteLine("Да");
            else
                Console.WriteLine("Нет");
            Console.ReadLine();
        }
        static void distanceBetweenPoints(double x, double y, double z, double x1, double y1, double z1)
        {
            double result = Math.Sqrt(Math.Pow((x1 - x), 2) + Math.Pow((y1 - y), 2) + Math.Pow((z1 - z), 2));
            Console.WriteLine("Расстояние между точками равно: {0:F2}", result );
            Console.ReadLine();
        }


        static void initFromUser1(ref double x, ref double y, ref double z)
        {
            Console.WriteLine("Задача #21");
            try
            {
                Console.WriteLine("Введите координаты точки А!");
                Console.WriteLine("введите x: ");
                x = double.Parse(Console.ReadLine());
                Console.WriteLine("введите y: ");
                y = double.Parse(Console.ReadLine());
                Console.WriteLine("введите z: ");
                z = double.Parse(Console.ReadLine());

            }
            catch (Exception exc)
            {
                Console.WriteLine($"Ошибка ввода! Перезапусти программу, иначе результат будет неверным!{exc.Message}");
                return;
            }
        }

        static void initFromUser2(ref double x1, ref double y1, ref double z1)
        {
            try
            {
                Console.WriteLine("Введите координаты точки В!");
                Console.WriteLine("введите x1: ");
                x1 = double.Parse(Console.ReadLine());
                Console.WriteLine("введите y1: ");
                y1 = double.Parse(Console.ReadLine());
                Console.WriteLine("введите z1: ");
                z1 = double.Parse(Console.ReadLine());

            }
            catch (Exception exc)
            {
                Console.WriteLine($"Ошибка ввода!Перезапусти программу, иначе результат будет неверным!{exc.Message}");
                return;
            }
        }
        static void Cubes(ref int num)
        {
            Console.WriteLine("Задача #23");
            try
            {
                Console.WriteLine("Введите число: ");
                num = int.Parse(Console.ReadLine());
            }
            catch (Exception exc)
            {
                Console.WriteLine($"Ошибка ввода {exc.Message}"); return;
            }
            for (int i = 1; i <= num; i++)
                Console.WriteLine(i * i * i);
        }
        public static void Main(string[] args)
        {


            double x = 0, y = 0, z = 0, x1 = 0, y1 = 0, z1 = 0;
            int n = 0; int num = 0;

            Palindrom(ref n);

            initFromUser1(ref x, ref y, ref z);
            initFromUser2(ref x1, ref y1, ref z1);
            distanceBetweenPoints(x, y, z, x1, y1, z1);

            Cubes(ref num);

            Console.ReadLine();
        }
    }
}
