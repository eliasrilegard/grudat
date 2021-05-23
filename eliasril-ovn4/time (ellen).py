import matplotlib.pyplot as plt
import time

def pow(n):
	"""Return 2**n, where n is a nonnegative integer."""
	if n == 0:
		return 1
	x = pow(n//2)
	if n%2 == 0:
		return x*x
	return 2*x*x

def sum1(a):
	"""Return the sum of the elements in the list a."""
	n = len(a)
	if n == 0:
		return 0
	if n == 1:
		return a[0]
	return sum1(a[:n//2]) + sum1(a[n//2:])


def sum2(a):
	"""Return the sum of the elements in the list a."""
	return _sum(a, 0, len(a)-1)

def _sum(a, i, j):
	"""Return the sum of the elements from a[i] to a[j]."""
	if i > j:
		return 0
	if i == j:
		return a[i]
	mid = (i+j)//2
	return _sum(a, i, mid) + _sum(a, mid+1, j)



def main():

    list = [10, 100, 1000, 10000, 100000, 1000000]
    powlist=[]
    sum1list=[]
    sum2list=[]

    for n in list:
        templist=[1]*n

        start = time.time()
        pow(n)
        powlist.append(time.time() - start)

        start = time.time()
        sum1(templist)
        sum1list.append(time.time() - start)

        start = time.time()
        sum2(templist)
        sum2list.append(time.time() - start)


    print(powlist)
    print()
    plt.loglog(list,powlist, label="pow")
    plt.loglog(list,sum1list,label="sum1")
    plt.loglog(list,sum2list,label="sum2")
    plt.legend()
    plt.show()



if __name__ == '__main__': main()
