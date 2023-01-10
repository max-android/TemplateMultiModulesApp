package com.example.common

import java.io.IOException

class NoInternetException(cause: Throwable): IOException(cause)