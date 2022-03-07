package com.example.movieinfo

import com.example.movieinfo.model.movielist.Movie
import com.example.movieinfo.model.movielist.MovieUiModel
import com.example.movieinfo.repository.MovieRepository
import com.example.movieinfo.repository.RemoteMovieDataSource
import com.example.movieinfo.source.MovieDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(MockitoJUnitRunner::class)
class MovieUnitTest {

    @Test
    fun `영화 api 호출시, 응답 데이터(Movie)가 null 일 경우, MovieUiModel 에서 빈 문자열로 초기화 되는지`() {
        //given
        val movieEmpty = Movie(null, null, null, null, null, null)
        val movieUiModel = MovieUiModel.newInstance(movieEmpty)

        // then
        assertEquals(movieUiModel.movieName, "")
        assertEquals(movieUiModel.movieEnglishName, "")
        assertEquals(movieUiModel.movieProductYear, "")
        assertEquals(movieUiModel.movieType, "")
        assertEquals(movieUiModel.movieNation, "")
        assertEquals(movieUiModel.movieKind, "")
    }

    @Test
    fun `repository 에서 페이지 인덱스를 올바르게 호출하는지`() = runBlocking<Unit> {
        //given
        val mockSource = mock(MovieDataSource::class.java)
        val repository = MovieRepository(mockSource)

        //when
        repository.fetchMovieList(true)
        repository.fetchMovieList(false)

        //then
        verify(mockSource, times(1)).fetchMovieList(1)
        verify(mockSource, times(1)).fetchMovieList(2)
    }

    @Test
    fun `영화인 api 호출 시, 응답 Row data 개수를 올바르게 호출하는지`() = runBlocking<Unit> {
        //given
        val mockSource = RemoteMovieDataSource()
        val repository = MovieRepository(mockSource)

        //when
        val size = withContext(Dispatchers.IO) {
            repository.fetchMovieStarList(false)?.movieStarListData?.movieStar?.size
        }

        //then
        assertEquals(size, 12)
    }


}