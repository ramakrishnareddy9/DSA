# def isNumber(n):
#     sum = 0
#     temp = n
#     while temp != 0:
#         sum += (temp % 10)
#         temp //= 10
#     return n % sum == 0

# n = int(input())
# print(isNumber(n))

# def fib(n):
#     a, b = 0, 1
#     print(0)
#     print(1)
#     for _ in range(2, n):
#         res = a + b
#         print(f"{res}")
#         a = b
#         b = res

# n = int(input())
# fib(n)

# def trib(n):
#     a ,b ,c= 0, 1 ,1
#     print(a)
#     print(b)
#     print(c)
#     for _ in range(3, n):
#         res = a + b + c
#         print(f" {res}")
#         a ,b,c = b,c,res
# n = int(input())
# trib(n)


# def happyNumber(n):
#     seen = list()
#     while n != 1 and n not in seen:
#         seen.append(n)
#         n = sumSquares(n)
#     return n == 1

# def sumSquares(n):
#     res = 0
#     while n != 0:
#         res += (n % 10) ** 2
#         n //= 10
#     return res

# n = int(input())
# print(happyNumber(n))


# def ponic(n):
#     temp = n ** 0.5
#     for i in range(temp):
#         if(i * (i + 1) == n):
#             return True
#     return False

# def optimizedPonic(n):
#     res = int(n ** 0.5)
#     return res * (res + 1) == n

# n = int(input())
# print(optimizedPonic(n))

# def evilNumber(n):
#     a = toBinary(n)
#     count = 0
#     for i in a:
#         if i == '1':
#             count += 1
#     if(count % 2 == 0):
#         return True
#     return False
    
# def toBinary(n):
#     if n == 0:
#         return "0"
#     binary = ""
#     while n > 0:
#         binary = str(n % 2) + binary
#         n //= 2
#     return binary

# n = int(input())
# print(evilNumber(n))

# def nelsonNumb(n):
#     check = n % 10
#     while(n != 0):
#         if(n % 10 != check):
#             return False
#         n //= 10
#     return True
    
# n = int(input())
# print(nelsonNumb(n))


# def neonNumber(n):
#     temp = n * n
#     res = 0
#     while(temp != 0):
#         res = res + (temp % 10)
#         temp //= 10
#     return res == n

# n = int(input())
# print(neonNumber(n))

# def uniqueNumb(n):
#     l = list()
#     while(n != 0):
#         if(n % 10 not in l):
#             l.append(n % 10)
#         else:
#             return False
#         n //= 10
#     return True
# n = int(input())
# print(uniqueNumb(n))

# def perfectSquare(n):
#     res = int(n ** 0.5)
#     return res * res == n
# n = int(input())
# print(perfectSquare(n))

# def automorphicNumber(n):
#     sq = n * n
#     return str(sq).endswith(str(n))

# def automorphicNumber1(n):
#     sq = n * n
#     count = 0
#     temp = n

#     while temp != 0:
#         count += 1
#         temp //= 10
#     p = int(10 ** count)
#     res = sq % p
#     return n == res

# n = int(input())
# print(automorphicNumber(n))
# print(automorphicNumber1(n))

def find(l,n):
    for i in range(len(l)):
        if l[i] == n: return i
    return -1

l = list(map(int,input().split()))
n = int(input())

print(find(l,n))