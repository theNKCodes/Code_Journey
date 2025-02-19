#include <stdio.h>
#include <stdlib.h>
#include <gmp.h>

void primeFactorization(int argc, char *argv[])
{
    if (argc != 2)
    {
        return;
    }

    mpz_t n;
    mpz_init_set_str(n, argv[1], 10);

    mpz_t div;
    mpz_init(div);
    mpz_set_ui(div, 2);

    // Handle the case of even numbers
    while (mpz_divisible_ui_p(n, 2) != 0)
    {
        gmp_printf("%d ", 2);
        mpz_divexact_ui(n, n, 2);
    }

    // Continue with odd divisors
    mpz_set_ui(div, 3);
    mpz_t sqrt_n;
    mpz_init(sqrt_n);
    mpz_sqrt(sqrt_n, n);
    int arr[1000] = {0};
    int j = 1;
    while (mpz_cmp(div, sqrt_n) <= 0)
    {
        if (mpz_divisible_p(n, div) != 0)
        {
            arr[j] = mpz_get_ui(div);
            j++;
            mpz_divexact(n, n, div);
            mpz_sqrt(sqrt_n, n); // Update square root of n
        }
        else
        {
            mpz_add_ui(div, div, 2); // Skip even divisors
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
    printf(" ");
    if (mpz_cmp_ui(n, 1) > 0)
    {
        gmp_printf("%Zd", n); // Print the remaining prime factor
    }

    mpz_clears(div, n, sqrt_n, NULL);
}

int main(int argc, char *argv[])
{
    primeFactorization(argc, argv);
    return 0;
}
