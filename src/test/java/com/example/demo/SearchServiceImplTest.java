package com.example.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by elvira.pratiwi on 08-Mar-21
 */
public class SearchServiceImplTest {
  @InjectMocks
  private SearchServiceImpl searchService;

  @Before
  public void setUp() {
    initMocks(this);
  }
//
//  @After
//  public void tearDown() {
//
//  }

  @Test
  public void searchById_iphone() {
    Phone result = searchService.searchById("2");
    System.out.println(result);
    assertEquals("Iphone 12",result.getName());
    assertEquals("2",result.getId());
    assertEquals("ios 12",((IPhone)result).getIosVersion());
  }

  @Test
  public void searchById_samsung() {
    Phone result = searchService.searchById("1");
    System.out.println(result);
    assertEquals("Samsung Note 10",result.getName());
    assertEquals("1",result.getId());
    assertEquals("Android 10",((Samsung)result).getAndroidVersion());
  }

  @Test
  public void findAllPhoneName() {
    Map<String, List<String>> result = searchService.findAllPhoneName();
    System.out.println(result);
    assertNotNull(result);
  }
}
