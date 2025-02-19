#include <stdio.h>
#include <stdlib.h>
#include <gmp.h>

void gcd(mpz_t gcd_result, mpz_t a, mpz_t b)
{
    if (mpz_cmp_ui(b, 0) == 0)
    {
        mpz_set(gcd_result, a);
    }
    else
    {
        mpz_t tmp;
        mpz_init(tmp);
        mpz_mod(tmp, a, b);
        gcd(gcd_result, b, tmp);
        mpz_clear(tmp);
    }
}
void find_com_div(int argc, char *argv[])
{
    if (argc < 2)
    {
        return;
    }

    int n = atoi(argv[1]);
    if (argc != n + 2)
    {
        return;
    }

    mpz_t m[n];
    for (int i = 0; i < n; i++)
    {
        mpz_init_set_str(m[i], argv[i + 2], 10);
    }
    mpz_t fin_gcd;
    mpz_init_set(fin_gcd, m[0]);
    for (int i = 1; i < n; i++)
    {
        gcd(fin_gcd, fin_gcd, m[i]);
    }
    int arr[1000] = {0};
    int j = 1;
    for (int i = 1; i <= mpz_get_ui(fin_gcd); i++)
    {
        if (mpz_divisible_ui_p(fin_gcd, i))
        {
            arr[j] = i;
            j++;
        }
    }
    int i = 1;
    while (arr[i] != 0)
    {
        if (arr[i + 1] != 0)
        {
            printf("%d ", arr[i]);
        }
        else
        {
            printf("%d", arr[i]);
        }
        i++;
    }
    mpz_clear(fin_gcd);
    for (int i = 0; i < n; i++)
    {
        mpz_clear(m[i]);
    }
}

int main(int argc, char *argv[])
{
    find_com_div(argc, argv);
    return 0;
}