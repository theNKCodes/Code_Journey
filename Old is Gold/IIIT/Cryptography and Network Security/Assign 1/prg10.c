#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <gmp.h>

void eulerTotient(mpz_t phi, const mpz_t n)
{
    mpz_t i;
    mpz_init(i);
    mpz_set_ui(phi, 1);

    mpz_t m_minus_ones;
    mpz_init(m_minus_ones);
    mpz_sub_ui(m_minus_ones, n, 1);

    for (mpz_set_ui(i, 2); mpz_cmp(i, m_minus_ones) < 0; mpz_add_ui(i, i, 1))
    {
        mpz_t gcd_res;
        mpz_init(gcd_res);
        mpz_gcd(gcd_res, i, n);
        if (mpz_cmp_ui(gcd_res, 1) == 0)
        {
            mpz_add_ui(phi, phi, 1);
        }
        mpz_clear(gcd_res);
    }

    mpz_clears(i, m_minus_ones, NULL);
}

bool isPrimitiveRoot(const mpz_t g, const mpz_t m, const mpz_t phi)
{
    mpz_t i, final;
    mpz_init(i);
    mpz_init(final);

    for (mpz_set_ui(i, 1); mpz_cmp(i, phi) < 0; mpz_add_ui(i, i, 1))
    {
        mpz_powm(final, g, i, m);
        if (mpz_cmp_ui(final, 1) == 0)
        {
            mpz_clears(i, final, NULL);
            return false;
        }
    }

    mpz_clears(i, final, NULL);
    return true;
}

void Primitive_Roots(int argc, char *argv[])
{
    if (argc != 2)
    {
        return;
    }
    mpz_t m;
    mpz_init_set_str(m, argv[1], 10);
    mpz_t phi;
    mpz_init(phi);
    eulerTotient(phi, m);
    int ctr = 0;
    mpz_t g;
    mpz_init(g);
    int arr[1000] = {0};
    int j = 1;
    for (mpz_set_ui(g, 2); mpz_cmp(g, m) < 0; mpz_add_ui(g, g, 1))
    {
        mpz_t gcd_result;
        mpz_init(gcd_result);
        mpz_gcd(gcd_result, g, m);
        if (mpz_cmp_ui(gcd_result, 1) == 0 && isPrimitiveRoot(g, m, phi))
        {
            arr[j] = mpz_get_ui(g);
            j++; 
            ctr++;
        }
        mpz_clear(gcd_result);
    }
    mpz_clears(phi, g, NULL);
    printf("%d ", ctr);
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
    mpz_clear(m);
}
int main(int argc, char *argv[])
{
    Primitive_Roots(argc, argv);
    return 0;
}
