#include <stdio.h>
#include <gmp.h>
#include <assert.h>
#include <unordered_map>
#include <gmpxx.h>
#include <iostream>

std::unordered_map<char, int> charMap = {
    {'0', 0}, {'1', 1}, {'2', 2}, {'3', 3}, {'4', 4}, {'5', 5}, {'6', 6}, {'7', 7}, {'8', 8}, {'9', 9}, {' ', 10}, {'a', 11}, {'b', 12}, {'c', 13}, {'d', 14}, {'e', 15}, {'f', 16}, {'g', 17}, {'h', 18}, {'i', 19}, {'j', 20}, {'k', 21}, {'l', 22}, {'m', 23}, {'n', 24}, {'o', 25}, {'p', 26}, {'q', 27}, {'r', 28}, {'s', 29}, {'t', 30}, {'u', 31}, {'v', 32}, {'w', 33}, {'x', 34}, {'y', 35}, {'z', 36}
};

void generateRandomPrime(mpz_t prime, unsigned int bits) {
    gmp_randstate_t state;
    gmp_randinit_default(state);
    mpz_urandomb(prime, state, bits);
    while (!mpz_probab_prime_p(prime, 25)) {
        mpz_nextprime(prime, prime);
    }
    gmp_randclear(state);
}

void calculateRSAKeys(mpz_t n, mpz_t d, const mpz_t p, const mpz_t q, const mpz_t e) {
    mpz_mul(n, p, q);

    mpz_t p1, q1, lambda, gcd, mul, mod;
    mpz_inits(p1, q1, lambda, gcd, mul, mod, NULL);
    mpz_sub_ui(p1, p, 1);
    mpz_sub_ui(q1, q, 1);
    mpz_lcm(lambda, p1, q1);

    printf("lambda = %s\n", mpz_get_str(NULL, 0, lambda));
    // e must be greater than 1
    assert(mpz_cmp_ui(e, 1) > 0);

    // e must be less than lambda
    assert(mpz_cmp(lambda, e) > 0);

    // GCD(e, lambda) must be 1
    mpz_gcd(gcd, e, lambda);
    assert(mpz_cmp_ui(gcd, 1) == 0);

    mpz_invert(d, e, lambda);

    // e * d MOD lambda must be 1
    mpz_mul(mul, e, d);
    mpz_mod(mod, mul, lambda);
    assert(mpz_cmp_ui(mod, 1) == 0);

    mpz_clears(gcd, p1, q1, mul, mod, lambda, NULL);
}

void encryptMessage(mpz_t encrypted,
             const mpz_t message,
             const mpz_t e,
             const mpz_t n) {
    mpz_powm(encrypted, message, e, n);
}

void decryptMessage(mpz_t original,
             const mpz_t encrypted,
             const mpz_t d,
             const mpz_t n) {
    mpz_powm(original, encrypted, d, n);
}

void displayMessage(const mpz_t message,
                 const mpz_t n,
                 const mpz_t e,
                 const mpz_t d) {
    mpz_t encrypted, decrypted;
    mpz_inits(encrypted, decrypted, NULL);
    encryptMessage(encrypted, message, e, n);
    decryptMessage(decrypted, encrypted, d, n);
    assert(mpz_cmp(message, decrypted) == 0);
    printf("Original message: %s\n", mpz_get_str(NULL, 0, message));
    printf("Encrypted message: %s\n", mpz_get_str(NULL, 0, encrypted));
    printf("Decrypted message: %s\n", mpz_get_str(NULL, 0, decrypted));
    printf("\n");

    mpz_clears(encrypted, decrypted, NULL);
}

void showMessage(const char *msg,
                 const char *p,
                 const char *q,
                 const char *e) {
    printf("Initializing with p = %s, q = %s, e = %s\n", p, q, e);

    mpz_t n, d, pVal, qVal, eVal, original;
    mpz_inits(n, d, pVal, qVal, eVal, original, NULL);
    mpz_set_str(pVal, p, 10);
    mpz_set_str(qVal, q, 10);
    mpz_set_str(eVal, e, 10);
    mpz_set_str(original, msg, 10);
    calculateRSAKeys(n, d, pVal, qVal, eVal);
    displayMessage(original, n, eVal, d);

    mpz_clears(n, d, pVal, qVal, eVal, original, NULL);
}


int main(int argc, char *argv[]) {
    if (argc != 2) {
        std::cerr << "Usage: " << argv[0] << " <plaintext_string>\n";
        return 1;
    }

    std::string text = argv[1];
    mpz_class original = 0;
    for (char c : text) {
        original *= 37;
        original += charMap[c];
    }
    
    showMessage(original.get_str().c_str(),
                "162259276829213363391578010288127",
                "618970019642690137449562111",
                "170141183460469231731687303715884105727");

    return 0;
}
