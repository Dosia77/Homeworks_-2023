
print('Задача про монеты')
print()
countCoins = int(input('введите количество монет: '))

count_0 =0
count_1 =0

for i in range(countCoins):
    coin = int(input('введите 0 или 1: '))
               
    if coin == 0:
        count_0 +=1
    else:
        count_1 +=1

if count_1 == countCoins or count_0 == countCoins:
    revers = 0   #print(0)
elif count_0 >= count_1:
    revers = count_1  #print(count_1)
            
else:
    revers = count_0 #print(count_0)         
         
print(f'количество монет: {countCoins}, количество переворотов: {revers}')         
 
print()
print('Два загаданных числа')
print()

number_1 = int(input('введите произведение чисел: '))
number_2 = int(input('введите сумму чисел: '))

for i in range(1,number_2):
    if number_1%i == 0 and (number_1/i)+i == number_2:
        print(f'{number_1} {number_2} -> {i}')      


print()
print('Степени двойки меньше заданного числа')
print()

n = int(input('введите максимальное число до степени: '))

i = 0
res = 1

print(f'{n} -> 1 ')
while res < n:
    res = res*2
    i += 1
    if res < n:
        print(res)






