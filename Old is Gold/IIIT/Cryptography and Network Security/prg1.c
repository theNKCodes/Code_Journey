#include <stdio.h>
#include <stdlib.h>
#include <gmp.h>

void gcd(mpz_t gcd_res, mpz_t p, mpz_t q)
{
    if (mpz_cmp_ui(q, 0) == 0)
    {
        mpz_set(gcd_res, p);
    }
    else
    {
        mpz_t tmp;
        mpz_init(tmp);
        mpz_mod(tmp, p, q);
        gcd(gcd_res, q, tmp);
        mpz_clear(tmp);
    }
}

void find_common_divisors(int argc, char *argv[])
{
    if (argc < 2)
    {
        return;
    }
    int n = atoi(argv[1]);
    mpz_t m[n];
    for (int i = 0; i < n; i++)
    {
        mpz_init_set_str(m[i], argv[i + 2], 10);
    }
    mpz_t f_gcd;
    mpz_init_set(f_gcd, m[0]);
    for (int i = 1; i < n; i++)
    {
        gcd(f_gcd, f_gcd, m[i]);
    }
    for (int i = 1; i <= mpz_get_ui(f_gcd); i++)
    {
        if (mpz_divisible_ui_p(f_gcd, i))
        {
            printf("%d ", i);
        }
    }
    printf("\n");
    mpz_clear(f_gcd);
    for (int i = 0; i < n; i++)
    {
        mpz_clear(m[i]);
    }
}

int main(int argc, char *argv[])
{
    find_common_divisors(argc, argv);
    return 0;
}