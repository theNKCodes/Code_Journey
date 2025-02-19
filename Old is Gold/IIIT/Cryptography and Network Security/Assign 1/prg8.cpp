#include <bits/stdc++.h>
#include <gmpxx.h>
using namespace std;

mpz_class GCD(mpz_class m, mpz_class n)
{
	if (m == 0)
		return n;
	return GCD(n % m, m);
}

mpz_class inv(mpz_class a, mpz_class m)
{
	mpz_class m0 = m, t, q;
	mpz_class x0 = 0, x1 = 1;

	if (m == 1)
		return 0;
	while (a > 1)
	{
		q = a / m;
		t = m;
		m = a % m, a = t;
		t = x0;

		x0 = x1 - q * x0;

		x1 = t;
	}
	if (x1 < 0)
		x1 += m0;

	return x1;
}
int main(int argc, char *argv[])
{
	int n = stoi(argv[1]);
	vector<mpz_class> arr1(n);
	vector<mpz_class> arr2(n);
	vector<mpz_class> arr3(n);
	for (int i = 0; i < n; ++i)
	{
		arr1[i] = argv[3 * i + 2];
		arr2[i] = argv[3 * i + 3];
		arr3[i] = argv[3 * i + 4];
	}

	for (int i = 0; i < n; ++i)
	{
		mpz_class g = GCD(arr1[i], arr3[i]);
		arr1[i] = arr1[i] / g;
		arr2[i] = arr2[i] / g;
		arr3[i] = arr3[i] / g;

		mpz_class in = inv(arr1[i], arr3[i]);
		arr2[i] = arr2[i] * in;
	}

	mpz_class prod = 1;
	for (int i = 0; i < n; i++)
		prod = prod * arr3[i];

	mpz_class result = 0;
	for (int i = 0; i < n; i++)
	{
		mpz_class pp = prod / arr3[i];
		result += arr2[i] * inv(pp, arr3[i]) * pp;
	}

	if(result != 0){
		cout << "Y " << result % prod;
	} else {
		cout<<"N";
	}

	return 0;
}