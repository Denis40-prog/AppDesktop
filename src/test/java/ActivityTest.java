import com.ProjetSport.Controller.ActivityControllerImpl;
import com.ProjetSport.model.Activity;
import com.ProjetSport.repository.ActivityRepository;
import org.mockito.Mock;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Calendar;
import java.util.Date;

import static com.mongodb.assertions.Assertions.fail;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
public class ActivityTest {
    @ExtendWith(MockitoExtension.class)
    @DisplayName("Group of units tests for the activity controller")
    public class ActivityControllerImplTest {

        @Mock
        ActivityRepository activityRepository;
        Activity activityTest = new Activity(
                "Christine",
                90,
                "60",
                "50",
                new Date(2022, Calendar.DECEMBER, 1)
        );
        Activity brokenActivity = new Activity(
                "Christine",
                90,
                "60",
                "50",
                new Date(2020, Calendar.DECEMBER, 10)
        );
        String id = "idChristine";

        ActivityControllerImpl classUnderTest;

        @BeforeEach
        public void setUp () {
            classUnderTest = new ActivityControllerImpl(activityRepository);
        }

        @Disabled
        @Test
        @DisplayName("Test an action")
        public void voidAction_isTested_shouldFail () {

            fail("Not yet implemented");
        }

        @Test
        @DisplayName("Test if the save method of the repository is called with an Activity")
        public void save_withActivity_shouldCallRepository () {
            //Arrange
            when(activityRepository.save(activityTest)).thenReturn(id);

            //Act
            String result = classUnderTest.saveActivity(activityTest);

            //Assert
            verify(activityRepository).save(activityTest);
            verify(activityRepository).save(any(Activity.class));
            verify(activityRepository, times(1))
                    .save(any(Activity.class));
            verify(activityRepository, never()).getAll();
            assertThat(result).isEqualTo(id);
        }
    }
}