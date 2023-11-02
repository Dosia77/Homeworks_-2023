print()
print('Степень числа')

a = int(input('Введите число для возведения в степень: '))
n = int(input('Введите степень, в которую возводить: '))

def Power(a,n): 
    if n == 0: 
        return 1
    else:
        return  a*(Power(a,n-1))
        
print(f'Число {a} в степени {n} равно: {Power(a,n)}')  

print()
print('Сложение чисел')
print()

a = int(input('Введите первое число: '))
n = int(input('Введите второе число: '))

def Sum(a,n): 
    if n != 0: 
        a = a+1
   
        return (Sum(a,n-1))
    else: 
        return a
        
print(f'Сумма числа {a} и числа {n} равна: {Sum(a,n)}')   
   

   
