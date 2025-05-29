export type Place = {
    id: number
    title: string
    childPlaces?: Place []
}

export const travelPlan:Place[] = [{
    id: 1,
    title: 'Earth',
    childPlaces: [{
      id: 2,
      title: 'Africa',
      childPlaces: [{
        id: 3,
        title: 'Botswana',
      }, {
        id: 4,
        title: 'Egypt',
      }, {
        id: 5,
        title: 'Kenya',
      }, {
        id: 6,
        title: 'Madagascar',
      }, {
        id: 7,
        title: 'Morocco',
      }, {
        id: 8,
        title: 'Nigeria',
      }, {
        id: 9,
        title: 'South Africa',
      }]
    }, {
      id: 10,
      title: 'Americas',
      childPlaces: [{
        id: 11,
        title: 'Argentina',
      }, {
        id: 12,
        title: 'Brazil',
      }, {
        id: 13,
        title: 'Barbados',
      }, {
        id: 14,
        title: 'Canada',
      }, {
        id: 15,
        title: 'Jamaica',
      }, {
        id: 16,
        title: 'Mexico',
      }, {
        id: 17,
        title: 'Trinidad and Tobago',
      }, {
        id: 18,
        title: 'Venezuela',
      }]
    }, {
      id: 19,
      title: 'Asia',
      childPlaces: [{
        id: 20,
        title: 'China',
      }, {
        id: 21,
        title: 'India',
      }, {
        id: 22,
        title: 'Singapore',
      }, {
        id: 23,
        title: 'South Korea',
      }, {
        id: 24,
        title: 'Thailand',
      }, {
        id: 25,
        title: 'Vietnam',
      }]
    }, {
      id: 26,
      title: 'Europe',
      childPlaces: [{
        id: 27,
        title: 'Croatia',
      }, {
        id: 28,
        title: 'France',
      }, {
        id: 29,
        title: 'Germany',
      }, {
        id: 30,
        title: 'Italy',
      }, {
        id: 31,
        title: 'Portugal',
      }, {
        id: 32,
        title: 'Spain',
      }, {
        id: 33,
        title: 'Turkey',
      }]
    }, {
      id: 34,
      title: 'Oceania',
      childPlaces: [{
        id: 35,
        title: 'Australia',
      }, {
        id: 36,
        title: 'Bora Bora (French Polynesia)',
      }, {
        id: 37,
        title: 'Easter Island (Chile)',
      }, {
        id: 38,
        title: 'Fiji',
      }, {
        id: 39,
        title: 'Hawaii (the USA)',
      }, {
        id: 40,
        title: 'New Zealand',
      }, {
        id: 41,
        title: 'Vanuatu',
      }]
    }]
  }, {
    id: 42,
    title: 'Moon',
    childPlaces: [{
      id: 43,
      title: 'Rheita',
    }, {
      id: 44,
      title: 'Piccolomini',
    }, {
      id: 45,
      title: 'Tycho',
    }]
  }, {
    id: 46,
    title: 'Mars',
    childPlaces: [{
      id: 47,
      title: 'Corn Town',
    }, {
      id: 48,
      title: 'Green Hill',
    }]
  }]
