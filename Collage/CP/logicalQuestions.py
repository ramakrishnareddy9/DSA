a,*b,c = 'python'
print(a,b,c)

lst = ['madam','apple']
print([w for w in lst if w == w[::-1]])

lst = [1,2,3]
for i in lst:
    ++i
    print(i,end= " ") # 1,2,3 -> because of unary + 

print(True + False == 0, 0 == False, [] == False)

x,y,z = 10,9,8
if(x > y > z): # Chained Comparisions
    print(True)
else:
    print(False)

x = 5
y = x == 5 and 10
print(y)

text = 'programming'
print('gram' in text)

a = [1,2,3,4]
a[1:3] = []
print(a) # [1,4]

n = 3 + 4j
print(n)
print(abs(n)) # 3^2 + 4^2 = 25 -> sqrt 25 -> 5
# the abs() function computes the magnitude (or modulus ) of the complex number 

r = 0
for i in range(5):
    r += 1
    i += 5
print(r) # output is 5 as i+=5 wont effect for loop

lst1 = [1,1,1,0,1]
lst2 = [0,0,0,0,0]
lst3 = [1,1,1,1,1]

print(all(lst1))
print(all(lst2))
print(all(lst3))

lst1 = [1,1,1,0,1]
lst2 = [0,0,0,0,0]
lst3 = [1,1,1,1,1]

print(any(lst1))
print(any(lst2))
print(any(lst3))

data = [1,2,3]
for i in data:
    data.remove(i)
print(data)

print(bool(0),bool(""),bool([]))

x = [[0]*3]*3
x[0][0] = 1
print(x) # [[1, 0, 0], [1, 0, 0], [1, 0, 0]]

x = {'orders' : 0}
x['orders'] += 1
print(x) 

x = '7'
print(int(x) * x)

n = 'vishnu' 'vardhan' # concate
x = 'rama' , 'krishna' # tuple
print(n)
print(x)

x = int(input())
if x == 1 or 2 or 3 or 4 or 5:
    print("yes")
else:
    print("no")

l1 =['in','as','if','be']
print(l1[1:][:2])

lst = ['a','b','c','d']
for ele in lst:
    if ele == 'b':
        lst.remove('b')
    else:
        print(ele)

print(min(0.0,-0.0)) # 0.0
print(min(-0.0,0.0)) # -0.0

print(round(1.5))
print(round(2.5)) 
# bankers rounding round to nearst even number

num = [10,20,30,40,50]
num[1 : 4] = [15,18,20]
print(num)

def add(a,b):
    return a + 5,b + 5

result = add(4,6)
print(result) # (9,11)

def mul(a,b):
    return a * b
result = mul(5,0) or mul(3,4)
print(result)

x = (1,2,3)
y = (4)
print(x + y) # erroe

x = (1,2,3)
y = (4,)
print(x + y) # (1,2,3,4)

names = ["ram", 'krishna']
print(max(names)) # high ascii values will print